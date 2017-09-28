package com.chicken.bot.echo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chicken.bot.echo.utils.KoreanUtils;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@SpringBootApplication
@LineMessageHandler
public class Application {
	private String[][] replaceWords = {{"지수", "진솔"}, {"진솔", "지수"}};
	private KoreanUtils utils = new KoreanUtils();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
	}
		
	@EventMapping
	public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
		System.out.println("event: " + event);
		
		String resultText = this.replaceWords(event.getMessage().getText());
		
		return new TextMessage(resultText);
	
	}
	
	@EventMapping
	public void handleDefaultMessageEvent(Event event) {
		System.out.println("event: " + event);
		
	}
	
	private String replaceWords(String text) {
		String replaceText = StringUtils.replaceEach(text, replaceWords[0], replaceWords[1]);
		return utils.correctSuffix(replaceText);
		
	}

}