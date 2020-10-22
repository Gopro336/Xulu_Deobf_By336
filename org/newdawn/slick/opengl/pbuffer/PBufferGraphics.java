package org.newdawn.slick.opengl.pbuffer;

import org.newdawn.slick.util.*;
import org.lwjgl.opengl.*;
import org.newdawn.slick.*;
import org.newdawn.slick.opengl.*;
import org.lwjgl.*;

public class PBufferGraphics extends Graphics
{
    private /* synthetic */ Image image;
    private /* synthetic */ Pbuffer pbuffer;
    
    protected void initGL() {
        GL11.glEnable(3553);
        GL11.glShadeModel(7425);
        GL11.glDisable(2929);
        GL11.glDisable(2896);
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glClearDepth(1.0);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glViewport(0, 0, this.screenWidth, this.screenHeight);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        this.enterOrtho();
    }
    
    @Override
    protected void enable() {
        SlickCallable.enterSafeBlock();
        try {
            if (this.pbuffer.isBufferLost()) {
                this.pbuffer.destroy();
                this.init();
            }
            this.pbuffer.makeCurrent();
        }
        catch (Exception lllllllllllllllllIIIIIlIIIlllIll) {
            Log.error("Failed to recreate the PBuffer");
            throw new RuntimeException(lllllllllllllllllIIIIIlIIIlllIll);
        }
        PBufferGraphics.GL.glBindTexture(3553, this.image.getTexture().getTextureID());
        this.pbuffer.releaseTexImage(8323);
        TextureImpl.unbind();
        this.initGL();
    }
    
    private void init() throws SlickException {
        try {
            final Texture lllllllllllllllllIIIIIlIIlIIlIlI = InternalTextureLoader.get().createTexture(this.image.getWidth(), this.image.getHeight(), this.image.getFilter());
            final RenderTexture lllllllllllllllllIIIIIlIIlIIlIIl = new RenderTexture(false, true, false, false, 8314, 0);
            this.pbuffer = new Pbuffer(this.screenWidth, this.screenHeight, new PixelFormat(8, 0, 0), lllllllllllllllllIIIIIlIIlIIlIIl, (Drawable)null);
            this.pbuffer.makeCurrent();
            this.initGL();
            PBufferGraphics.GL.glBindTexture(3553, lllllllllllllllllIIIIIlIIlIIlIlI.getTextureID());
            this.pbuffer.releaseTexImage(8323);
            this.image.draw(0.0f, 0.0f);
            this.image.setTexture(lllllllllllllllllIIIIIlIIlIIlIlI);
            Display.makeCurrent();
        }
        catch (Exception lllllllllllllllllIIIIIlIIlIIlIII) {
            Log.error(lllllllllllllllllIIIIIlIIlIIlIII);
            throw new SlickException("Failed to create PBuffer for dynamic image. OpenGL driver failure?");
        }
    }
    
    @Override
    public void destroy() {
        super.destroy();
        this.pbuffer.destroy();
    }
    
    @Override
    public void flush() {
        super.flush();
        this.image.flushPixelData();
    }
    
    @Override
    protected void disable() {
        PBufferGraphics.GL.flush();
        PBufferGraphics.GL.glBindTexture(3553, this.image.getTexture().getTextureID());
        this.pbuffer.bindTexImage(8323);
        try {
            Display.makeCurrent();
        }
        catch (LWJGLException lllllllllllllllllIIIIIlIIlIIIIIl) {
            Log.error((Throwable)lllllllllllllllllIIIIIlIIlIIIIIl);
        }
        SlickCallable.leaveSafeBlock();
    }
    
    protected void enterOrtho() {
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, (double)this.screenWidth, 0.0, (double)this.screenHeight, 1.0, -1.0);
        GL11.glMatrixMode(5888);
    }
    
    public PBufferGraphics(final Image lllllllllllllllllIIIIIlIIlIIlllI) throws SlickException {
        super(lllllllllllllllllIIIIIlIIlIIlllI.getTexture().getTextureWidth(), lllllllllllllllllIIIIIlIIlIIlllI.getTexture().getTextureHeight());
        this.image = lllllllllllllllllIIIIIlIIlIIlllI;
        Log.debug(String.valueOf(new StringBuilder().append("Creating pbuffer(rtt) ").append(lllllllllllllllllIIIIIlIIlIIlllI.getWidth()).append("x").append(lllllllllllllllllIIIIIlIIlIIlllI.getHeight())));
        if ((Pbuffer.getCapabilities() & 0x1) == 0x0) {
            throw new SlickException("Your OpenGL card does not support PBuffers and hence can't handle the dynamic images required for this application.");
        }
        if ((Pbuffer.getCapabilities() & 0x2) == 0x0) {
            throw new SlickException("Your OpenGL card does not support Render-To-Texture and hence can't handle the dynamic images required for this application.");
        }
        this.init();
    }
}
