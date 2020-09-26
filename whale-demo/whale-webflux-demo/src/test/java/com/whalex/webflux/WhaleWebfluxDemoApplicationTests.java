package com.whalex.webflux;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class WhaleWebfluxDemoApplicationTests {

    /**
     * 创建方式，与订阅方式
     */
    @Test
    void contextLoads() {
        //创建Flux方式
        Flux<Integer> flux = Flux.just(1,2,3,4,5,6);
        //数组创建
        Integer[] integers = {1,2,3,4,5,6};
        Flux<Integer> arrayFlux = Flux.fromArray(integers);
        //集合创建
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Flux<Integer> listFlux = Flux.fromIterable(list);
        //Flux 创建 另一个 Flux
        Flux<Integer> fluxFlux = Flux.from(flux);
        //流创建flux
        Flux<Integer> streamFlux = Flux.fromStream(Stream.of(1,2,3,4,5,6));
        //Mono创建
        Mono<Integer> mono = Mono.just(1);

        //订阅
        flux.subscribe();
        flux.subscribe(System.out::print, //输出
                System.err::print, //错误输出
                ()->System.out.println("complete") //完成时输出
        );
        streamFlux.subscribe(
                System.out::println,
                System.err::println,
                ()->System.out.println("complete"),
                subscription -> subscription.request(3)); //背压一次收3个
        //自定义实现
        flux.subscribe(new DemoSubscriper());
    }

    class DemoSubscriper extends BaseSubscriber<Integer> {

        @Override
        protected void hookOnSubscribe(Subscription subscription) {
            System.out.println("DemoSubscriper");
            subscription.request(1);

        }

        @Override
        protected void hookOnNext(Integer value) {
            if(value == 4){
                cancel();
            }
            System.out.println(value);
            request(1);
        }
    }

    /**
     * 测试操作符
     */
    @Test
    void operationFlux(){
        //创建Flux方式
        Flux<Integer> flux = Flux.just(1,2,3,4,5,6);

        //创建Flux方式
        Flux<String> stringFlux = Flux.just("Hello","world","I","am","is","JY");

        //数组创建
        Integer[] integers = {1,2,3,4,5,6};
        Flux<Integer> arrayFlux = Flux.fromArray(integers);
        //集合创建
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Flux<Integer> listFlux = Flux.fromIterable(list);

        flux.map(i->i*3).subscribe(System.out::println);
        System.out.println("-----------");
        stringFlux.flatMap(i->stringFlux).subscribe(System.out::println); //会将stream中的元素展开输出
        System.out.println("-----------");
        flux.filter(i -> i>3).subscribe(System.out::println);
        System.out.println("-----------");
        Flux.zip(flux,arrayFlux).subscribe(zip->System.out.println(zip.getT1() + zip.getT1()));
    }

    /**
     * 创建线程池，以及使用方式
     */
    @Test
    void createThreadPools(){
        Flux<Integer> flux = Flux.just(1,2,3,4,5,6);
        flux.map(i->{
            System.out.println(Thread.currentThread().getName()+"-map1");
            return i * 3;
        }).publishOn(Schedulers.elastic()) //指定线程池
                .map(i-> {
                    System.out.println(Thread.currentThread().getName()+"-map2");
                    return i / 3;
                })
          .subscribe(it-> System.out.println(Thread.currentThread().getName()+"-"+it));
    }
}
