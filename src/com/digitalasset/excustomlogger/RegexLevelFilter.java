package com.digitalasset.excustomlogger;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.AbstractMatcherFilter;
import ch.qos.logback.core.spi.FilterReply;

public class RegexLevelFilter extends AbstractMatcherFilter<ILoggingEvent> {
	private String regexPattern;
	private Level newLevel;
	
	public void setRegexPattern(String regexPattern) {
		this.regexPattern = regexPattern;
	}
	
	public void setNewLevel(Level newLevel) {
		this.newLevel = newLevel;
	}
	
	@Override
	public FilterReply decide(ILoggingEvent event) {
		if (!isStarted()) {
			return FilterReply.NEUTRAL;
		}
		String message = event.getFormattedMessage();
		if (event.getLevel().levelInt >= newLevel.levelInt || message.matches(regexPattern))   
			return FilterReply.ACCEPT;
		return FilterReply.DENY;
	}
}