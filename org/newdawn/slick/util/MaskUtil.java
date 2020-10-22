package org.newdawn.slick.util;

import org.newdawn.slick.opengl.renderer.*;

public class MaskUtil
{
    protected static /* synthetic */ SGL GL;
    
    public static void drawOnMask() {
        MaskUtil.GL.glDepthFunc(514);
    }
    
    static {
        MaskUtil.GL = Renderer.get();
    }
    
    public static void resetMask() {
        MaskUtil.GL.glDepthMask(true);
        MaskUtil.GL.glClearDepth(0.0f);
        MaskUtil.GL.glClear(256);
        MaskUtil.GL.glDepthMask(false);
        MaskUtil.GL.glDisable(2929);
    }
    
    public static void defineMask() {
        MaskUtil.GL.glDepthMask(true);
        MaskUtil.GL.glClearDepth(1.0f);
        MaskUtil.GL.glClear(256);
        MaskUtil.GL.glDepthFunc(519);
        MaskUtil.GL.glEnable(2929);
        MaskUtil.GL.glDepthMask(true);
        MaskUtil.GL.glColorMask(false, false, false, false);
    }
    
    public static void drawOffMask() {
        MaskUtil.GL.glDepthFunc(517);
    }
    
    public static void finishDefineMask() {
        MaskUtil.GL.glDepthMask(false);
        MaskUtil.GL.glColorMask(true, true, true, true);
    }
}
