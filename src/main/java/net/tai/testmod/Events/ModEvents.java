package net.tai.testmod.Events;

import static org.apache.commons.compress.harmony.pack200.PackingUtils.log;

public class ModEvents {
    public ModEvents(){

    }
    public static void register(){
        log("Registering Events");

        LootTableModifiers.register();
    }
}
