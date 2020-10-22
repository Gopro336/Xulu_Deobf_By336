package com.elementars.eclient.module.misc;

import dev.xulu.settings.*;
import com.elementars.eclient.command.*;
import com.elementars.eclient.module.*;

public class AutoQMain extends Module
{
    private /* synthetic */ int wait;
    private final /* synthetic */ Value<Boolean> message;
    private final /* synthetic */ Value<Integer> delay;
    
    @Override
    public void onEnable() {
        this.wait = 12000;
    }
    
    @Override
    public void onUpdate() {
        if (AutoQMain.mc.getCurrentServerData() == null || (AutoQMain.mc.getCurrentServerData() != null && !AutoQMain.mc.getCurrentServerData().serverIP.equals("2b2t.org"))) {
            this.wait = 0;
            Command.sendChatMessage("Server not 2b2t.org, disabling...");
            this.disable();
        }
        else {
            if (this.wait <= 0) {
                AutoQMain.mc.player.sendChatMessage("/queue main");
                if (this.message.getValue()) {
                    Command.sendChatMessage("Did /queue main");
                }
                this.wait = this.delay.getValue();
            }
            --this.wait;
        }
    }
    
    public AutoQMain() {
        super("AutoQMain", "Automatically sends /queue main", 0, Category.MISC, true);
        this.message = this.register(new Value<Boolean>("Debug Messages", this, false));
        this.delay = this.register(new Value<Integer>("Seconds", this, 120, 10, 600));
    }
}
