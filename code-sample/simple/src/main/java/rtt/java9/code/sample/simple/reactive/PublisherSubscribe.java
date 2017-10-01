package rtt.java9.code.sample.simple.reactive;

import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;

public class PublisherSubscribe {

    static class SampleSubscriber<T> implements Subscriber<T> {
        private Subscription subscription;
        @Override
        public void onSubscribe(Subscription subscription) {
            this.subscription = subscription;
            subscription.request(1);
        }
        @Override
        public void onNext(T item) {
            try {
                Thread.sleep(1_000); // long running operation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Processed item: "+ item.toString());
            subscription.request(1);
        }
        @Override
        public void onError(Throwable t) { t.printStackTrace(); }
        @Override
        public void onComplete() { subscription.cancel(); }
    }

    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        SampleSubscriber<String> subscriber = new SampleSubscriber<>();
        publisher.subscribe(subscriber);
        List.of("1", "x", "2", "x", "3", "x").forEach( item -> {
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publisher.submit(item);
        });
        publisher.close();
        System.out.println("Going to sleep");
        Thread.sleep(1_000);
        System.out.println("Wakeup");
    }

}
