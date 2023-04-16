package org.kd.test.hamcrest_matchers;

import org.hamcrest.MatcherAssert;
import org.kd.hamcrest_matchers.RegexMatcher;
import org.testng.annotations.Test;

public class CustomMatcherTest {

    @Test
    public void testRegularExpressionMatcher() {
        String s = "aaabbbaaaa";
        MatcherAssert.assertThat(s, RegexMatcher.matchesRegex("a*b*a*"));
    }

}
