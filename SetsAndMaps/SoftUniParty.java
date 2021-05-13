package com.company;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipMembers = new TreeSet<>();
        Set<String> regularMembers = new TreeSet<>();

        String partyComers = scanner.nextLine();

        while (!partyComers.equals("PARTY")){
            if (Character.isDigit(partyComers.charAt(0))){
                vipMembers.add(partyComers);
            }else {
                regularMembers.add(partyComers);
            }
            partyComers = scanner.nextLine();
        }

        String partyLeavers = scanner.nextLine();

        while (!partyLeavers.equals("END")){
            if (Character.isDigit(partyLeavers.charAt(0))){
                vipMembers.remove(partyLeavers);
            }else {
                regularMembers.remove(partyLeavers);
            }
            partyLeavers = scanner.nextLine();
        }
        System.out.println(vipMembers.size() + regularMembers.size());
        if (!vipMembers.isEmpty()){
            String collect = getString(vipMembers);
            System.out.println(collect);
        }
        if (!regularMembers.isEmpty()){
            String collect = getString(regularMembers);
            System.out.println(collect);
        }
    }

    private static String getString(Set<String> vipMembers) {
        return vipMembers.stream().collect(Collectors.joining(System.lineSeparator()));
    }
}
