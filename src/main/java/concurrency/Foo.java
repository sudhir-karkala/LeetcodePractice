package concurrency;

import java.util.concurrent.Semaphore;

/**
 * Suppose we have a class:
 *
 * <pre>
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * </pre>
 * <p>
 * The same instance of Foo will be passed to three different threads.
 * Thread A will call first(), thread B will call second(), and thread C will call third().
 * Design a mechanism and modify the program to ensure that second() is executed after
 * first(), and third() is executed after second().
 *
 * @author sudhir on 01-Sep-2020
 * @see <a href="https://leetcode.com/problems/print-in-order/">
 * https://leetcode.com/problems/print-in-order/</a>
 */
public class Foo {
    Semaphore sem2 = new Semaphore(0);
    Semaphore sem3 = new Semaphore(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        sem2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        sem2.acquire();
        printSecond.run();
        sem3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        sem3.acquire();
        printThird.run();
    }
}
