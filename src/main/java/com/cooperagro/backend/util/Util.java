package com.cooperagro.backend.util;

import com.cooperagro.backend.model.generic.GenericTabela;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Util {

    static Method method;

    public static String getUCFirst(String name) {
        return getFirstChar(name).toUpperCase() + name.substring(1);
    }

    public static Object invokeMethod(GenericTabela genericTabela, String methodName, Object object) {
        Class<?> cls = genericTabela.getClass();

        method = null;
        try {
            if (object == null) {
                method = cls.getMethod(methodName);
                return method.invoke(genericTabela);
            } else {
                method = cls.getMethod(methodName, object.getClass());
                return method.invoke(genericTabela, object);
            }

        } catch (NoSuchMethodException | SecurityException e) {
            throw new RuntimeException("A classe: " + cls.getName() + " não possui o metodo: " + methodName + " com visibilidade pública, ou n�o existe!");
        } catch (IllegalAccessException |
                 IllegalArgumentException |
                 InvocationTargetException e) {
            throw new RuntimeException("Houve um erro desconhecido na execu��o do m�todo:" + cls.getName() + "." + methodName, e);
        }
    }

    public static Object invokeGetMethod(GenericTabela genericTabela, String fieldName) {
        String methodName = getGetterMethodName(fieldName);
        return invokeMethod(genericTabela, methodName, null);
    }

    public static void invokeSetMethod(GenericTabela genericTabela, String fieldName, Object object) {
        String methodName = getSettterMethodName(fieldName);
        invokeMethod(genericTabela, methodName, object);
    }

    public static String getGetterMethodName(String fieldName) {
        return "get" + Util.getUCFirst(fieldName);
    }

    public static String getSettterMethodName(String fieldName) {
        return "set" + Util.getUCFirst(fieldName);
    }

    public static String getLastChar(String str) {
        return str.substring(str.length() - 1);
    }

    public static String getFirstChar(String str) {
        return str.substring(0, 1);
    }

    public static boolean isEmpty(final String value) {
        return StringUtils.isEmpty(value);
    }

    public static String getValorConcatenado(final String separador, Object... parametros) {
        return Util.getValorConcatenado(separador, Arrays.asList(parametros));
    }

    public static String getValorConcatenado(final String separador, final List<Object> parametros) {
        StringBuilder build = new StringBuilder();
        Iterator<?> iterator = parametros.iterator();

        while (iterator.hasNext()) {
            Object valor = iterator.next().toString();
            build.append(valor);

            if (iterator.hasNext()) {
                build.append(separador);
            }
        }
        return build.toString();
    }

    public static boolean isCnpjValido(String cnpj) {
        if (cnpj.length() == 14) {
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

    public static boolean isNotNull(String string) {
        return string != null;
    }

    public static Object getRepositoryClass(String repositoryName) {
        try {
            repositoryName = "com.ueg.nutshellbackend.application.repository." + repositoryName;
            return Class.forName(repositoryName).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Não foi possível encontrar a repositorye: " + repositoryName, e);
        }
    }

}
