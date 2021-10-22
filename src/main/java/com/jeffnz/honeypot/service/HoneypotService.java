package com.jeffnz.honeypot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import java.util.Date;

@Service
public class HoneypotService {
	private final Logger log = LoggerFactory.getLogger(HoneypotService.class);

	public StreamingResponseBody getInfiniteResponse() {
		StreamingResponseBody stream = out -> {
			while (true) {
				String msg = "Not Found\n";
				log.info("handleRandomGetRequest() is rendering - "+ new Date());
				out.write(msg.getBytes());
				out.flush();
				wait(5);
			}
		};
		return stream;
	}

	private static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
