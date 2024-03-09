package com.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;

public class SimpleBlock {
    private static final String HEXES = "0123456789ABCDEF";
    int index;
    ZonedDateTime zonedDateTime;
    String data;
    String previousHash;
    public SimpleBlock() {
    }
    public String createHash(int index, ZonedDateTime zonedDateTime, String data, String previousHash) throws NoSuchAlgorithmException {
        String originalString = "";
        String hashedString = "";
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashbytes = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
            hashedString = bytesToHex(hashbytes);
        } catch(NoSuchAlgorithmException nsae) {
            throw nsae;
        }
        return hashedString;
    }
    private static String bytesToHex(byte[] raw) {
        final StringBuilder hex = new StringBuilder(2 * raw.length);
        for (final byte b : raw) {
            hex.append(HEXES.charAt((b & 0xF0) >> 4)).append(HEXES.charAt((b & 0x0F)));
        }
        return hex.toString();
    }
}

