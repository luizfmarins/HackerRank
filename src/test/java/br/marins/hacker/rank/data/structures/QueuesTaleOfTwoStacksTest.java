package br.marins.hacker.rank.data.structures;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import br.marins.hacker.rank.data.structures.QueuesTaleOfTwoStacks.MyQueue;
import org.junit.Test;

public class QueuesTaleOfTwoStacksTest {

  private final MyQueue<Integer> sut = new MyQueue<>();

  @Test
  public void enqueue_peek() {
    sut.enqueue(1);
    Integer peek = sut.peek();

    assertThat(peek, equalTo(1));
  }

  @Test
  public void enqueue_enqueue_peek() {
    sut.enqueue(1);
    sut.enqueue(2);
    Integer peek = sut.peek();

    assertThat(peek, equalTo(1));
  }


  @Test
  public void enqueue_enqueue_dequeue() {
    sut.enqueue(1);
    sut.enqueue(2);

    assertThat(sut.dequeue(), equalTo(1));
    assertThat(sut.dequeue(), equalTo(2));
  }

  @Test
  public void enqueue3_dequeue_enqueue_dequeue() {
    sut.enqueue(1);
    sut.enqueue(2);
    sut.enqueue(3);

    assertThat(sut.dequeue(), equalTo(1));

    sut.enqueue(4);

    assertThat(sut.dequeue(), equalTo(2));
  }
}