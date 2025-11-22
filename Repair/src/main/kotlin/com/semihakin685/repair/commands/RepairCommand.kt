package com.semihakin685.repair.commands

import cn.nukkit.Player
import cn.nukkit.command.Command
import cn.nukkit.command.CommandSender
import cn.nukkit.item.ItemArmor
import cn.nukkit.item.ItemTool
import cn.nukkit.level.Sound

class RepairCommand : Command ("repair", "Repairs the item in your hand.") {

    init {
        this.permission = "repair.command"
    }

    override fun execute(sender: CommandSender, commandLabel: String?, args: Array<out String?>?): Boolean {

        if (sender !is Player) {
            sender.sendMessage("Only players can use this command.")
            return false
        }

        val hand = sender.inventory.itemInHand

        if (hand !is ItemTool && hand !is ItemArmor) {
            sender.sendMessage("§c» The item you have cannot be repaired.")
            return false
        }

        if (hand.damage < 20) {
            sender.sendMessage("§c» The item you have is not very worn.")
            return false
        }

        hand.damage = 0
        sender.inventory.itemInHand = hand
        sender.level.addSound(sender.location, Sound.RANDOM_ANVIL_USE)
        sender.sendMessage("§a» The item has been repaired.")
        return true
    }
}