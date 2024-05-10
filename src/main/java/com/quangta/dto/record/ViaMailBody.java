package com.quangta.dto.record;

import lombok.Builder;

@Builder
public record ViaMailBody(String to, String subject, String text) {}
