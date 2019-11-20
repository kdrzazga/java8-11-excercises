package org.kd.jfugeexamples;

//Im IntelliJ right-click jfugue-5.0.9.jar and choose Add to Libraries
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;
import org.jfugue.theory.Chord;
import org.jfugue.theory.ChordProgression;
import org.jfugue.theory.Note;

class Fugue1 implements Runnable {

    private static final Player player = new Player();
    public static void main(String[] args) {

        Fugue1 f = new Fugue1();

        f.run();

        player.play("E5s A5s"
                + " C6s B5s E5s B5s D6s C6i E6i G#5i" +
                " E6i | A5s E5s A5s C6s B5s E5s B5s D6s C6i A5i Ri");
    }

    public void run() {
        int cnt = 10000;
        while (cnt >0) {

            //playOnaTanczy(player);
            //playRythm2(player);

            //playBarka(player);
            //player.play("V0 I[Piano] Eq Ch. | Eq Ch. | Dq Eq Dq Cq   V1 I[Flute] Rw | Rw | GmajQQQ CmajQ");

            //player.play("C D E F G A B");
            //w, h, q, i, s, t, x, o (whole, half, etc. down to 128th)

            //player.play("Cw Do Eq Fx G A B");

            cnt--;
            //pattern1(player);
            //chordProgression(player);
        /*try {
            twelveBarBlues(player);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        }
    }

    private static void playOnaTanczy(Player player) {
        //player.play("c c c c a c d e d c d c c c c c a e d c d e d c c c c a c d e d c d c c c c c a e d c d e d c d c");

        player.play("c c d c c e f e c e d h c d c c d h c e f e c e e d h c d c");


    }

    private static void playRuthm1(Player player) {
        Rhythm rhythm = new Rhythm()
                .addLayer("O..oO...O..oOO..")
                .addLayer("..S...S...S...S.")
                .addLayer("````````````````")
                .addLayer("...............+");

        player.play(rhythm.getPattern().repeat(10));

    }

    private static void playRythm2(Player player) {
        Rhythm rhythm = new Rhythm()
                .addLayer("O..oO...O..oOO..") // This is Layer 0
                .addLayer("..S...S...S...S.")
                .addLayer("````````````````")
                .addLayer("...............+") // This is Layer 3
                .addOneTimeAltLayer(3, 2, "...+...+...+...+") // Replace Layer 3 with this string on the 2th (count from 0) measure
                .setLength(6); // Set the length of the rhythm to 4 measures

        player.play(rhythm.getPattern().repeat(1));
    }

    public static void playBarka(Player player) {
        player.play("E D E F E D C C" +
                "D E F F F F F E D D" +
                "D C D E E E F D C C");
        player.play("C C A A A H C2 H A G G" +
                "F E F F F G A G F E E" +
                "C C A A A H C2 H A G G" +
                "F E F F D E F E D C");
    }

    private static void pattern1(Player player) {
        Pattern p1 = new Pattern("V0 I[Piano] Eq Ch. | Eq Ch. | Dq Eq Dq Cq");
        Pattern p2 = new Pattern("V1 I[Flute] Rw     | Rw     | GmajQQQ  CmajQ");
        player.play(p1, p2);
    }

    private static void chordProgression(Player player) {
        System.out.println("chords");
        ChordProgression cp = new ChordProgression("I IV V");

        Chord[] chords = cp.setKey("C").getChords();
        for (Chord chord : chords) {
            System.out.print("Chord " + chord + " has these notes: ");
            Note[] notes = chord.getNotes();
            for (Note note : notes) {
                System.out.print(note + " ");
            }
            System.out.println();
        }

        player.play(cp);
    }

    private static void twelveBarBlues(Player player) {
        System.out.println("12 bar blues");
        Pattern pattern = new ChordProgression("I IV V")
                .distribute("7%6")
                .allChordsAs("$0 $0 $0 $0 $1 $1 $0 $0 $2 $1 $0 $0")
                .eachChordAs("$0ia100 $1ia80 $2ia80 $3ia80 $4ia100 $3ia80 $2ia80 $1ia80")
                .getPattern()
                .setInstrument("Acoustic_Bass")
                .setTempo(100);
        player.play(pattern);
    }
}