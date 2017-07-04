package CompanyQuestions;
import java.util.*;
public class Streams {

    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */
    public static class Solution {

        interface Stream<A> {
            A head();
            Stream<A> tail();
        }

        private static class StreamTests {

            static class ElementChecker<A> {

                final Stream<A> s;
                final int index;

                ElementChecker(Stream<A> s, int index) {
                    this.s = s;
                    this.index = index;
                }

                void shouldBe(A expected) {
                    Stream<A> _s = s;
                    int _index = index;
                    while (_index > 0) {
                        _s = _s.tail();
                        _index = _index - 1;
                    }
                    if (!expected.equals(_s.head())) {
                        throw new AssertionError(
                                "expected `" + expected + "` at index " + index + " but found `" + _s.head() + "`"
                        );
                    }
                }

            }

            static class StreamChecker<A> {
                final Stream<A> s;
                StreamChecker(Stream<A> s) {
                    this.s = s;
                }
                ElementChecker<A> elemAt(int index) {
                    return new ElementChecker(s, index);
                }
            }

            static <A> StreamChecker<A> with(Stream<A> s) {
                return new StreamChecker(s);
            }

        }

        static class StreamNode implements Stream<Integer> {
            Integer head;

            StreamNode(int index) {
                head = index;
            }

            public Integer head() {
                return head;
            }

            public Stream<Integer> tail() {
                return this;
            }
        }

        static class ConstStreams {

            static Stream<Integer> zeroes() {
                return new StreamNode(0);
            }

            static Stream<Integer> ones() {
                return new StreamNode(1);
            }

            static Stream<Integer> twos() {
                return new StreamNode(2);
            }

        }

        public static void main(String[] args) {
            StreamTests.with(ConstStreams.zeroes()).elemAt(0).shouldBe(0);
            StreamTests.with(ConstStreams.zeroes()).elemAt(1).shouldBe(0);
            StreamTests.with(ConstStreams.zeroes()).elemAt(50).shouldBe(0);
        }
    }
}
