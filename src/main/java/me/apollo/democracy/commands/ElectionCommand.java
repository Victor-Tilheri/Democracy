package me.apollo.democracy.commands;

import me.apollo.democracy.Democracy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class ElectionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("election")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length > 0) {
                    switch (args[0].toLowerCase(Locale.ROOT)) {
                        case "create":
                            player.getServer().broadcastMessage("Nova eleição iniciada!");
                            break;
                        case "apply":
                            player.sendMessage(Democracy.getPlugin().election.addCandidate(player.getName()));
                            break;
                        case "vote":
                            if(args.length == 2) {
                                player.sendMessage(Democracy.getPlugin().election.addVote(player.getName(), args[1]));
                            }
                            break;
                        case "candidates":
                            player.sendMessage(Democracy.getPlugin().election.getCandidates());
                            break;
                        case "finish":
                            player.getServer().broadcastMessage(Democracy.getPlugin().election.getResult());
                            break;
                        case "help":
                            player.sendMessage("Digite '/election create' para iniciar uma nova eleição.\n" +
                                    "Digite '/election apply' para candidatar-se.\n" +
                                    "Digite '/election candidates' para listar os candidatos." +
                                    "Digite '/election vote [nome]' para votar em um candidato." +
                                    "Digite '/election finish' para encerrar a eleição e ver o resultado.");
                            break;
                        default:
                            player.sendMessage(ChatColor.RED + "Comando desconhecido! Utilize: /election help");
                            break;
                    }
                }
            }
        }
        return true;
    }
}
