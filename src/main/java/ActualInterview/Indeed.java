package ActualInterview;


    /*
You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain. Every line consists of a click count and a domain name, like this:

counts = [ "900,google.com",
     "60,mail.yahoo.com",
     "10,mobile.sports.yahoo.com",
     "40,sports.yahoo.com",
     "300,yahoo.com",
     "10,stackoverflow.com",
     "20,overflow.com",
     "2,en.wikipedia.org",
     "1,m.wikipedia.org",
     "1,mobile.sports",
     "1,google.co.uk"]

Write a function that takes this input as a parameter and returns a data structure containing the number of clicks that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the bottom of the input.)

Sample output (in any order/format):

calculateClicksByDomain(counts) =>
com:                     1340
google.com:              900
stackoverflow.com:       10
overflow.com:            20
yahoo.com:               410
mail.yahoo.com:          60
mobile.sports.yahoo.com: 10
sports.yahoo.com:        50
org:                     3
wikipedia.org:           3
en.wikipedia.org:        2
m.wikipedia.org:         1
mobile.sports:           1
sports:                  1
uk:                      1
co.uk:                   1
google.co.uk:            1

n: number of domains in the input
(individual domains and subdomains have a constant upper length)
*/

import java.io.*;
import java.util.*;

public class Indeed {
    public static void main(String[] argv) {
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };

        Map<String, Integer> countMap = getClickCount(counts);

        countMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });

    }

    private static Map<String, Integer> getClickCount(String[] counts) {
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < counts.length; i++) {
            List<String> domainData = Arrays.asList(counts[i].split(","));

            int count = Integer.valueOf(domainData.get(0));
            String domain = domainData.get(1);

            // add it to the map
            addToMap(countMap, domain, count);

            // add subdomains to the map
            List<String> subDomains = Arrays.asList(domain.split("\\."));
            int index = 1;
            while (index < subDomains.size()) {
                StringBuilder subDomain = new StringBuilder();
                for (int j = index; j < subDomains.size() - 1; j++) {
                    subDomain.append(subDomains.get(j) + ".");
                }
                subDomain.append(subDomains.get(subDomains.size() - 1));
                addToMap(countMap, subDomain.toString(), count);
                index++;
            }
        }
        return countMap;
    }

    private static void addToMap(Map<String, Integer> countMap, String domain, int count) {
        if (countMap.get(domain) == null) {
            countMap.put(domain, count);
        } else {
            int newCount = countMap.get(domain) + count;
            countMap.put(domain, newCount);
        }
    }
}


