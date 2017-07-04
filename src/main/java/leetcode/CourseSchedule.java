package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule/#/description
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseSchedule {

    // Very very slow
    // see https://discuss.leetcode.com/topic/13854/easy-bfs-topological-sort-java for faster
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> outgoingEdges = new HashMap<>();
        Map<Integer, Set<Integer>> incomingEdges = new HashMap<>();
        Set<Integer> noIncoming = new HashSet<>();

        if (prerequisites.length == 0) {
            return true;
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preReq = prerequisite[1];

            noIncoming.remove(course);

            Set<Integer> incoming = incomingEdges.get(course);
            if (incoming == null) {
                Set<Integer> courseSet = new HashSet<>();
                courseSet.add(preReq);
                incomingEdges.put(course, courseSet);
            } else {
                incoming.add(preReq);
            }

            Set<Integer> outgoing = outgoingEdges.get(preReq);
            if (outgoingEdges.get(preReq) == null) {
                Set<Integer> courseSet = new HashSet<>();
                courseSet.add(course);
                outgoingEdges.put(preReq, courseSet);
            } else {
                outgoing.add(course);
            }

            if (!incomingEdges.containsKey(preReq)) {
                noIncoming.add(preReq);
            }


        }

        Queue<Integer> queue = new LinkedList<>();

        queue.addAll(noIncoming);
        int count = 0;
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            if (outgoingEdges.containsKey(currCourse)) {
                count++;
                for (Integer out: outgoingEdges.get(currCourse)) {
                    Set<Integer> incoming = incomingEdges.get(out);
                    if (incoming.remove(currCourse) && incoming.isEmpty()) {
                        incomingEdges.remove(out);
                        queue.add(out);
                    }
                }
            }
            outgoingEdges.remove(currCourse);
        }
        return count <= numCourses && outgoingEdges.isEmpty() && incomingEdges.isEmpty();
    }
}
