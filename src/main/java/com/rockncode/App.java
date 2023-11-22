package com.rockncode;

import com.rockncode.Models.Band;
import com.rockncode.Models.Member;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Band RockNCode = new Band("RocknCode");
        Member member1 = new Member("Pepito", "Drums", "Expert");
        Member member2 = new Member("Perez", "Vocalist", "Expert");
        Member member3 = new Member("Primero", "Bass", "Expert");

        RockNCode.addMember(member1);
        RockNCode.addMember(member2);
        RockNCode.addMember(member3);

        RockNCode.setGenre("Rock");
        RockNCode.setHistory("Too years ago...");
    }
}
