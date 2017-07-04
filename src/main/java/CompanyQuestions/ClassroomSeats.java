package CompanyQuestions;

import java.util.HashMap;
import java.util.Map;

public class ClassroomSeats {

/*

Classroom: n seats in a row, numbered 0 through n-1
Students enter and leave the room to take an exam, one at a time, in an arbitrary order.
Note that some students may enter after others have already left.
To prevent cheating, each student will be placed in the seat that maximizes the distance to the closest other student.
Ties will be broken by placing the student in the lower-numbered seat.
Write a class that supports:
    add(student_id) -> int: returns the index of the seat assigned to that student.
    remove(student_id) -> none

Example, with 10 seats:
Begin:          none  none  none  none  none  none  none  none  none  none
Add stu1:       stu1  none  none  none  none  none  none  none  none  none
Add stu2:       stu1  none  none  none  none  none  none  none  none  stu2
Add stu3:       stu1  none  none  none  stu3  none  none  none  none  stu2
Remove stu1:    none  none  none  none  stu3  none  none  none  none  stu2
Remove stu3:    none  none  none  none  none  none  none  none  none  stu2
Add stu4:       stu4  none  none  none  none  none  none  none  none  stu2

 */


    public static void main(String[] args) {
        ClassroomSeats soln = new ClassroomSeats(10);
        soln.add(1);
        soln.printArr();
        soln.add(2);
        soln.printArr();
        soln.add(3);
        soln.printArr();
        soln.remove(1);
        soln.remove(3);
        soln.add(4);
        soln.printArr();
    }

    int[] seats;

    Map<Integer, Integer> seatMap = new HashMap<>();

    ClassroomSeats(int size) {
        seats = new int[size];
    }

    int add(int studentId) {
        int maxDistance = 0;
        int bestIndex = 0;
        int numStudentsSoFar = 0;
        int[] recentStudents = {0, 0};

        if (seatMap.isEmpty()) {
            seatMap.put(studentId, bestIndex);
            seats[0] = studentId;
            return studentId;
        }

        for (int i = 0; i < seats.length; i++) {
            int curr = seats[i];

            if (curr == 0) {
                continue;
            }

            numStudentsSoFar++;

            if (numStudentsSoFar % 2 == 0) {
                recentStudents[0] = i;
            } else {
                recentStudents[1] = i;
            }

            if (numStudentsSoFar == 1) {
                int dist = i;
                maxDistance = dist;
                if (maxDistance > 0) {
                    bestIndex = 0;
                }
            }

            if (numStudentsSoFar > 1) {
                int dist = Math.abs(recentStudents[1] - recentStudents[0]) / 2;
                if (dist >= maxDistance) {
                    maxDistance = dist;
                    bestIndex = Math.abs(recentStudents[1] - recentStudents[0]) / 2;
                }
            }
        }

        int dist = (seats.length - 1 - Math.max(recentStudents[0], recentStudents[1]));
        if (dist >= maxDistance) {
            bestIndex = seats.length - 1;
        }
        seatMap.put(studentId, bestIndex);
        seats[bestIndex] = studentId;
        return bestIndex;
    }


    void remove(int studentId) {
        seats[seatMap.get(studentId)] = 0;
        seatMap.remove(studentId);
    }

    void printArr() {
        for (int i = 0; i < seats.length; i++) {
            System.out.print(seats[i] + " ");
        }
        System.out.println();
    }
}

