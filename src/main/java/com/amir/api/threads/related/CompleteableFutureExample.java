package com.amir.api.threads.related;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompleteableFutureExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("start main by "+Thread.currentThread().getName());
		
		Supplier<Integer> call = ()->{
			int i=1;
			int total=0;
			while(++i<10) {
				try {
					System.out.println("Running thread: "+Thread.currentThread().getName());
					Thread.sleep(1000);
					if(i==9) {
						throw new RuntimeException("INVALID");
					}
				} catch (InterruptedException e) {
					throw new RuntimeException("INVALID FROM CATCH");
				}
				total=total+i*10;
			}
			return total;
		};
		
		CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(call);
		cf.whenCompleteAsync((result, throwable) -> {
			if (Objects.nonNull(throwable)) {
				System.out.println("Opreation Failed");
				return;
			}
			System.out.println("Opreation Success");
		});
		
		System.out.println("finish main by "+Thread.currentThread().getName());
		
		TimeUnit.SECONDS.sleep(20);
	}

}
