package me.apollo.democracy.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class Election {
    private ArrayList<String> candidates = new ArrayList<String>();
    private ArrayList<Integer> votes = new ArrayList<Integer>();;
    private ArrayList<String> alreadyVoted = new ArrayList<String>();

    public void Election () {
    }

    public String addCandidate (String name) {
        String res = "";
        if (!candidates.contains(name)) {
            candidates.add(name);
            votes.add(0);
            res = "Agora você é um candidato, boa sorte!";
        } else {
            res = "Você já é um candidato!";
        }
        return res;
    }

    public String addVote (String voter, String candidate) {
        String res = "";
        if (!alreadyVoted.contains(voter)) {
            if (candidates.contains(candidate)) {
                int index = candidates.indexOf(candidate);
                votes.set(index, votes.get(index) + 1);
                alreadyVoted.add(voter);
                res = "Voto computado com sucesso!";
            } else {
                res = "Candidato não existe!";
            }
        } else {
            res = "Você já votou!";
        }
        return res;
    }

    public String getCandidates () {
        String result = "";
        for(int i = 0; i < candidates.size(); i++) {
            result += candidates.get(i) + "\n";
        }
        return result;
    }

    public String getResult() {
        String res = "";
        int sum = 0;
        for(int i = 0; i < votes.size(); i++) {
            sum += votes.get(i);
        }
        for(int i = 0; i < candidates.size(); i++) {
            double rate = (100 / sum) * votes.get(i);
            res += ChatColor.YELLOW + candidates.get(i) + " " + ChatColor.GREEN +  rate + "% " + ChatColor.YELLOW + "" + votes.get(i) + " voto(s)\n";
        }
        return res;
    }
}
