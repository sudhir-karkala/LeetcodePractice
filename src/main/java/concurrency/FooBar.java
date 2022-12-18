package concurrency;

import java.util.concurrent.Semaphore;

/**
 * Suppose you are given the following code:
 * <pre>
 * class FooBar {
 *  public void foo() {
 *      for (int i = 0; i < n; i++) {
 *          print("foo");
 *      }
 *  }
 *
 *  public void bar() {
 *      for (int i = 0; i < n; i++) {
 *          print("bar");
 *      }
 *  }
 * }
 * </pre>
 * <p>
 * The same instance of FooBar will be passed to two different threads.
 * Thread A will call foo() while thread B will call bar().
 * Modify the given program to output "foobar" n times.
 *
 * @author sudhir on 01-Sep-2020
 * @see <a href="https://leetcode.com/problems/print-foobar-alternately/">
 * https://leetcode.com/problems/print-foobar-alternately/</a>
 */
public class FooBar {
    private int n;
    Semaphore sem = new Semaphore(0);
    Semaphore sem2 = new Semaphore(1);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            sem2.acquire();
            printFoo.run();
            sem.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            sem.acquire();
            printBar.run();
            sem2.release();
        }
    }
}
