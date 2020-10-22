package org.reflections.adapters;

import java.util.*;
import org.reflections.vfs.*;

public interface MetadataAdapter<C, F, M>
{
    boolean acceptsInput(final String p0);
    
    String getMethodName(final M p0);
    
    String getReturnTypeName(final M p0);
    
    List<F> getFields(final C p0);
    
    List<String> getParameterNames(final M p0);
    
    String getSuperclassName(final C p0);
    
    String getMethodModifier(final M p0);
    
    C getOrCreateClassObject(final Vfs.File p0) throws Exception;
    
    String getFieldName(final F p0);
    
    String getMethodKey(final C p0, final M p1);
    
    List<String> getFieldAnnotationNames(final F p0);
    
    String getMethodFullKey(final C p0, final M p1);
    
    List<String> getMethodAnnotationNames(final M p0);
    
    List<String> getParameterAnnotationNames(final M p0, final int p1);
    
    List<String> getClassAnnotationNames(final C p0);
    
    String getClassName(final C p0);
    
    boolean isPublic(final Object p0);
    
    List<M> getMethods(final C p0);
    
    List<String> getInterfacesNames(final C p0);
}
