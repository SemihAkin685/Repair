package com.semihakin685.repair

import cn.nukkit.plugin.PluginBase
import com.semihakin685.repair.commands.RepairCommand

class Main : PluginBase() {

    override fun onEnable() {
        logger.info("Repair active")

        server.commandMap.register("repair", RepairCommand())
    }
}