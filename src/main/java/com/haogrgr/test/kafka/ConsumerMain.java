package com.haogrgr.test.kafka;

public class ConsumerMain {

	public static void main(String[] args) throws Exception {
		KafkaMessageConsumer consumerManager = new KafkaMessageConsumer("10.128.8.57:2181", "group-1", "haogrgr",
				new KafkaMessageHandler() {
					@Override
					public void consume(int partition, long offset, String key, String msg) {
						System.out.println(msg);
						if (key.equals("5"))
							throw new RuntimeException("x");
					}

					@Override
					public boolean accept(int partition, long offset, String key, String msg) {
						return false;
					}

					@Override
					public void handleError(int partition, long offset, String key, String msg, Throwable e) {

				}
				});

		consumerManager.afterPropertiesSet();

		Thread.sleep(100000000l);

		consumerManager.shutdown();
	}

}
