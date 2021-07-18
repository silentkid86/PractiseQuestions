package com.silentkid.practice.caching;

import sun.jvm.hotspot.runtime.Threads;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Main {

    public static void main(String[] argx) throws InterruptedException {
        final CacheBlock<String, String> cacheBlock =
                new CacheBlock<>(2, new LruRecencyPolicy<>());

        List<Thread> threads = new ArrayList<>();

        int OneThread = 3 ;
        int TwoThread = 6 ;
        int ThreeThread = 10 ;

        for(int i=0 ; i < OneThread ; i++){
            Thread t = new Thread( () -> {
                while(true){
                    try{
                        cacheBlock.put("1","one");
                        cacheBlock.get("2");
                    }catch (CacheMissException e){

                    }
                }
            });

            t.setDaemon(true);
            threads.add(t);
        }

        for(int i=0 ; i < TwoThread ; i++){
            Thread t = new Thread( () -> {
                while(true){

                    try{
                        cacheBlock.put("2","two");
                        cacheBlock.get("2");
                    }catch (CacheMissException e){

                    }
                }
            });

            t.setDaemon(true);
            threads.add(t);
        }

        for(int i=0 ; i < ThreeThread ; i++){
            Thread t = new Thread( () -> {
                while(true){
                    try{
                        cacheBlock.put("3","three");
                        cacheBlock.get("3");
                    }catch (CacheMissException e){

                    }


                }
            });

            t.setDaemon(true);
            threads.add(t);
        }

        for (Thread t: threads) {
            t.start();
        }

        Thread.sleep(200);

        for (Thread t: threads) {
            t.stop();
        }

        Thread.sleep(10);

        Enumeration<String> elements = cacheBlock.cache.elements();
        System.out.println("--------");
        System.out.println("Total Elements");
        while(elements.hasMoreElements()){
            String element = elements.nextElement();
            System.out.println(element);
        }
        System.out.println("policy queue" + cacheBlock.recencyPolicy.getSize());
    }

}
