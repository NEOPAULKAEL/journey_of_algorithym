package com.cro.leetcode;

import com.cro.leetcode.daily.Q2两数相加;
import com.cro.leetcode.daily.bfs.Q433最小基因变化;
import org.junit.jupiter.api.Test;

/**
 * @author cro
 * @description
 */
public class TestsForAll {

    @Test
    public void testQ433(){
        Q433最小基因变化.Solution q = new Q433最小基因变化().new Solution();
        q.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"});
    }

}
