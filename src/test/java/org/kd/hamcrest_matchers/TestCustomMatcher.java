package org.kd.hamcrest_matchers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestCustomMatcher {

    @Test
    public void testRegularExpressionMatcher() {
        String s = "aaabbbaaaa";
        assertThat(s, RegexMatcher.matchesRegex("a*b*a*"));
    }

}
