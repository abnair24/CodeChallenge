package com.abn.dsalgos.glc;

import org.testng.Assert;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of strings emails where we send one email to each email[i], return the number of
different addresses that actually receive mails.

https://leetcode.com/problems/unique-email-addresses/

Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2

Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
Output: 3
 */
public class ValidEmail {

    Set<String> result = new HashSet<>();

    public int numUniqueEmails(String[] emails) {

        for (int i = 0; i < emails.length; i++) {
            processEmail(emails[i]);
        }

        return result.size();
    }

    private void processEmail(String emails) {
        String[] emailArray = emails.split("@");

        String domain = emailArray[1];

        String localName = emailArray[0];

        String[] localHalfs = localName.split("\\+");
        String localHalf = localHalfs[0];

        StringBuilder sb = new StringBuilder();

        if (localHalf.contains(".")) {
            String[] array = localHalf.split("\\.");
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
            }
            result.add(sb.toString() + "@" + domain);

        } else {
            result.add(localHalf + "@" + domain);
        }
    }

    public static void main(String[] args) {

        ValidEmail validEmail = new ValidEmail();
        String[] emails1 = {
                "fg.r.u.uzj+o.pw@kziczvh.com",
                "r.cyo.g+d.h+b.ja@tgsg.z.com",
                "fg.r.u.uzj+o.f.d@kziczvh.com",
                "r.cyo.g+ng.r.iq@tgsg.z.com",
                "fg.r.u.uzj+lp.k@kziczvh.com",
                "r.cyo.g+n.h.e+n.g@tgsg.z.com",
                "fg.r.u.uzj+k+p.j@kziczvh.com",
                "fg.r.u.uzj+w.y+b@kziczvh.com",
                "r.cyo.g+x+d.c+f.t@tgsg.z.com",
                "r.cyo.g+x+t.y.l.i@tgsg.z.com",
                "r.cyo.g+brxxi@tgsg.z.com",
                "r.cyo.g+z+dr.k.u@tgsg.z.com",
                "r.cyo.g+d+l.c.n+g@tgsg.z.com",
                "fg.r.u.uzj+vq.o@kziczvh.com",
                "fg.r.u.uzj+uzq@kziczvh.com",
                "fg.r.u.uzj+mvz@kziczvh.com",
                "fg.r.u.uzj+taj@kziczvh.com",
                "fg.r.u.uzj+fek@kziczvh.com"
        };

        String[] emails = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };

        Assert.assertEquals(new ValidEmail().numUniqueEmails(emails1), 2);
        Assert.assertEquals(new ValidEmail().numUniqueEmails(emails), 2);
    }
}
