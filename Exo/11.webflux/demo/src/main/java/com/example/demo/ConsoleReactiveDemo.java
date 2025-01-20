//package com.example.demo;
//
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//public class ConsoleReactiveDemo {
//    // mono
//
//    Mono<String> mono = Mono.just("Hello World");
//        mono.subscribe(System.out::println);
//
//    // flux
//    Flux<String> flux = Flux.just("Hello", "World");
//        flux.subscribe(System.out::println);
//
//    // Operation sur flux
//    Flux<Integer> flux2 = Flux.range(1, 10)
//            .filter(i -> i % 2 == 0)
//            .map(i -> i * 10);
//
//        flux2.subscribe(System.out::println);
//
//    // erreur avec onErrorResume
//    Flux<String> errorFlux = Flux.just("1", "2", "3")
//            .map(value ->{
//                if("2".equals(value)) {
//                    throw new RuntimeException("Error simuler");
//                }
//                return value;
//            })
//            .onErrorResume(e -> Flux.just("Default1", "Default2", "Default3"));
//        errorFlux.subscribe(System.out::println, error -> System.err.println(error));
//
//
//    // onErrorContinue
//    Flux<Integer> errorFLUX2 = Flux.range(1, 10)
//            .map(value ->{
//                if(value == 3) {
//                    throw new RuntimeException("Error simuler");
//                }
//                return value;
//            })
//            .onErrorContinue((e, value) -> System.err.println("error sur : " + value + " : " + e.getMessage()));
//        errorFLUX2.subscribe(System.out::println, error -> System.err.println(error));
//}
