package com.example.demo.utils;

import com.example.demo.exception.AlertException;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AssertUtils {

    public static void throwAssetExceptionMsg(String message) throws AlertException {
        throw new AlertException(message);
    }

    public static void isFalse(boolean expression, String message) throws AlertException {
        if (expression) {
            throw new AlertException(message);
        }
    }


    public static void isFalse(boolean expression) throws AlertException {
        isFalse(expression, "[Assertion failed] - this expression must be false");
    }


    public static void isTrue(boolean expression, String message) throws AlertException {
        if (!expression) {
            throw new AlertException(message);
        }
    }

    public static void isNull(Object object, String message) throws AlertException {
        if (object != null) {
            throw new AlertException(message);
        }
    }

    public static void isNull(Object object) throws AlertException {
        isNull(object, "[Assertion failed] - the object argument must be null");
    }

    public static void notNull(Object object, String message) throws AlertException {
        if (object == null) {
            throw new AlertException(message);
        }
    }


    public static void doesNotContain(String textToSearch, String substring, String message)
        throws AlertException {
        if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) && textToSearch
            .contains(substring)) {
            throw new AlertException(message);
        }
    }

    public static void doesNotContain(String textToSearch, String substring) throws AlertException {
        doesNotContain(textToSearch, substring,
            "[Assertion failed] - this String argument must not contain the substring [" + substring
                + "]");
    }

    public static void notEmpty(Object[] array, String message) throws AlertException {
        if (ObjectUtils.isEmpty(array)) {
            throw new AlertException(message);
        }
    }

    public static void notEmpty(Object[] array) throws AlertException {
        notEmpty(array,
            "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    public static void noNullElements(Object[] array, String message) throws AlertException {
        if (array != null) {
            Object[] var2 = array;
            int var3 = array.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                Object element = var2[var4];
                if (element == null) {
                    throw new AlertException(message);
                }
            }
        }

    }

    public static void noNullElements(Object[] array) throws AlertException {
        noNullElements(array, "[Assertion failed] - this array must not contain any null elements");
    }

    public static void notEmpty(Collection<?> collection, String message) throws AlertException {
        if (CollectionUtils.isEmpty(collection)) {
            throw new AlertException(message);
        }
    }

    public static void notEmpty(Object obj, String message) throws AlertException {
        if (Objects.isNull(obj)) {
            throw new AlertException(message);
        }
    }

    public static void notEmpty(Collection<?> collection) throws AlertException {
        notEmpty(collection,
            "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

    public static void notEmpty(Map<?, ?> map, String message) throws AlertException {
        if (CollectionUtils.isEmpty(map)) {
            throw new AlertException(message);
        }
    }

    public static void notEmpty(Map<?, ?> map) throws AlertException {
        notEmpty(map,
            "[Assertion failed] - this map must not be empty; it must contain at least one entry");
    }

    @Deprecated
    public static void notEmtry(String str, String message) throws AlertException {
        if (str == null || str.length() == 0) {
            throw new AlertException(message);
        }
    }

    public static void notEmpty(String str, String message) throws AlertException {
        if (str == null || str.length() == 0) {
            throw new AlertException(message);
        }
    }

}
