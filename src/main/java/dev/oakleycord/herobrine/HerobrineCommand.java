package dev.oakleycord.herobrine;

import com.destroystokyo.paper.profile.PlayerProfile;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;

public class HerobrineCommand implements CommandExecutor {

    private final Herobrine main;

    public HerobrineCommand(Herobrine main) {
        this.main = main;
    }

    //meow meow meow :3
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("herobrine.command.herobrine")) {
            sender.sendMessage("You do not have permission to use this command.");
            return true;
        }
        if(!(sender instanceof Player player)) {
            sender.sendMessage("You must be a player to use this command");
            return false;
        }

        PlayerProfile profile = main.getServer().createProfile(player.getUniqueId(), "Herobrine");
        PlayerTextures playerTextures = profile.getTextures();
        try {
            playerTextures.setSkin(new URL("http://textures.minecraft.net/texture/5b36a152e7bf1b460731fb4ddf75be445371a029ca47716b4b6c82bd9df272ff"), PlayerTextures.SkinModel.CLASSIC);
        } catch (MalformedURLException e) {
            player.sendMessage("INVALID URL HAHAHA");
        }
        profile.setTextures(playerTextures);
        player.setPlayerProfile(profile);


        World world = player.getWorld();
        Location location = player.getBoundingBox().getCenter().toLocation(world);
        world.spawnParticle(Particle.FIREWORKS_SPARK, location, 20);
        world.playSound(player, Sound.ENTITY_GENERIC_EXPLODE, 1f,1.5f);
        return true;
    }
}
