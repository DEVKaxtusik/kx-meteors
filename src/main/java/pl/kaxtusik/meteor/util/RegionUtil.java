package pl.kaxtusik.meteor.util;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RegionUtil {

    private final WorldGuardPlugin worldGuard;

    public RegionUtil(Plugin plugin) {
        this.worldGuard = (WorldGuardPlugin) plugin.getServer().getPluginManager().getPlugin("WorldGuard");
    }

    public Location getRandomLocationInRegion(World world, String regionName) {
        if (worldGuard == null) return null;

        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        if (container == null) return null;

        RegionManager regions = container.get(BukkitAdapter.adapt(world));
        if (regions == null) return null;

        ProtectedRegion region = regions.getRegion(regionName);
        if (region == null) return null;

        int minX = region.getMinimumPoint().getBlockX();
        int minY = region.getMinimumPoint().getBlockY();
        int minZ = region.getMinimumPoint().getBlockZ();

        int maxX = region.getMaximumPoint().getBlockX();
        int maxY = region.getMaximumPoint().getBlockY();
        int maxZ = region.getMaximumPoint().getBlockZ();

        ThreadLocalRandom random = ThreadLocalRandom.current();
        Location randomLocation;

        do {
            int randomX = random.nextInt(minX, maxX + 1);
            int randomY = random.nextInt(minY, maxY + 1);
            int randomZ = random.nextInt(minZ, maxZ + 1);

            randomLocation = new Location(world, randomX, randomY, randomZ);
        } while (randomLocation.getBlock().getType() != Material.AIR);

        return randomLocation;
    }

    public boolean isPlayerInAnyRegion(Player player, List<String> regionNames) {
        if (worldGuard == null) return false;

        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        if (container == null) return false;

        RegionManager regions = container.get(BukkitAdapter.adapt(player.getWorld()));
        if (regions == null) return false;

        ApplicableRegionSet applicableRegions = regions.getApplicableRegions(BukkitAdapter.asBlockVector(player.getLocation()));

        for (ProtectedRegion region : applicableRegions) {
            if (regionNames.contains(region.getId())) {
                return true;
            }
        }
        return false;
    }
}
