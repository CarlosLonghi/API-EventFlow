package br.com.carloslonghi.eventflow.api.infra.util;

import br.com.carloslonghi.eventflow.api.core.util.EventIdentifierGenerator;

import java.util.Random;

public class EventIdentifierGeneratorImpl implements EventIdentifierGenerator {

    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int LENGTH = 8;
    private final Random random = new Random();

    @Override
    public String generate() {
        StringBuilder stringBuilder = new StringBuilder(LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            int randomNumber = random.nextInt(ALPHABET.length());
            stringBuilder.append(ALPHABET.charAt(randomNumber));
        }

        return stringBuilder.toString();
    }
}
