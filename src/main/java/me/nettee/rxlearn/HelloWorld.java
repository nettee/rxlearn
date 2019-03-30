package me.nettee.rxlearn;

import io.reactivex.Observable;

public class HelloWorld {

    public static void main(String[] args) {

        Observable.create(emitter -> {
            while (!emitter.isDisposed()) {
                long time = System.currentTimeMillis();
                emitter.onNext(time);
                if (time % 2 != 0) {
                    emitter.onError(new IllegalStateException("Odd millisec!"));
                    break;
                }
            }
        }).subscribe(System.out::println, Throwable::printStackTrace);
    }
}
