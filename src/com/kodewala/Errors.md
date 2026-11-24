# Java Errors

## 1. What is an Error in Java?

In Java, `Error` is a class that represents serious problems that generally occur during JVM execution or due to system-level issues.

The `Error` class belongs to the `java.lang` package and directly extends the `Throwable` class.

Errors generally indicate situations from which an application may not be able to recover normally.

**Important points:**

1. `Error` is a direct subclass of `Throwable`.
2. Errors are unchecked.
3. The compiler does not force us to handle or declare Errors.
4. Errors generally occur during runtime.
5. Errors usually indicate serious problems related to JVM execution, memory, class loading, or other low-level operations.
6. Errors can technically be caught using try-catch, but catching them does not guarantee recovery.

## 2. Error Hierarchy in Java

The hierarchy of Error is important for understanding how different Error classes are related.

```text
                         Object
                            |
                        Throwable
                       /         \
                    Error      Exception
                      |
          ---------------------------
          |            |            |
 VirtualMachineError LinkageError AssertionError
          |            |
      -----------   ----------------
      |         |    |              |
 OutOfMemory  Stack  NoClassDef   Unsatisfied
   Error     Overflow  FoundError  LinkError
               Error
```

The above diagram is simplified. The actual hierarchy contains additional subclasses.

### 2.1 Important Direct Subclasses of Error

Some important direct subclasses of `Error` are:

1. `VirtualMachineError`
2. `LinkageError`
3. `AssertionError`
4. `ThreadDeath`

## 3. Types of Errors in Java

Let's understand the important Error classes individually.

### 3.1 VirtualMachineError

`VirtualMachineError` is a subclass of `Error`.

It represents serious problems that prevent the JVM from operating normally.

Some important subclasses of `VirtualMachineError` are:

- `OutOfMemoryError`
- `StackOverflowError`
- `InternalError`
- `UnknownError`

#### A. OutOfMemoryError

`OutOfMemoryError` occurs when the JVM cannot allocate sufficient memory for an object or operation.

Java objects are generally allocated in the heap memory.

When the JVM cannot allocate the required memory, it may throw an `OutOfMemoryError`.

**Example:**

```java
import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {

        ArrayList<int[]> list = new ArrayList<>();

        while (true) {

            list.add(new int[1000000]);

        }
    }
}
```

**Explanation:**

1. We create an ArrayList.
2. Inside the infinite loop, we continuously create large integer arrays.
3. Each array is added to the ArrayList.
4. The ArrayList maintains references to these arrays.
5. Since the objects remain reachable, the garbage collector cannot reclaim them.
6. Eventually, the JVM may run out of heap memory.
7. An `OutOfMemoryError` can occur.

**Important:** This is an intentional example of memory exhaustion. Do not execute it in an environment where an application crash or memory exhaustion would be harmful.

#### B. StackOverflowError

`StackOverflowError` occurs when a thread requires more stack space than the JVM can provide.

Every method invocation creates a stack frame.

A stack frame stores information related to a method invocation, including local variables and intermediate execution details.

When a method continuously calls itself without reaching a termination condition, stack frames keep accumulating.

Eventually, the thread's stack space gets exhausted.

**Example:**

```java
public class Driver {

    static void display() {

        System.out.println("Hello");

        display();

    }

    public static void main(String[] args) {

        display();

    }
}
```

**Explanation:**

1. The main method calls `display()`.
2. The display method calls itself.
3. Every invocation creates another stack frame.
4. Previous invocations cannot complete because they are waiting for the next invocation to return.
5. Stack frames keep accumulating.
6. Eventually, the thread runs out of stack space.
7. JVM throws `StackOverflowError`.

**Important:** StackOverflowError is commonly associated with excessive or infinite recursion.

#### C. InternalError

`InternalError` is a subclass of `VirtualMachineError`.

It indicates an unexpected internal problem in the JVM.

It is generally associated with an issue in JVM implementation or internal execution.

Developers normally do not handle this Error in ordinary application code.

#### D. UnknownError

`UnknownError` is also a subclass of `VirtualMachineError`.

It represents an unexpected error condition that the JVM cannot classify more specifically.

It is rarely encountered in normal application development.

### 3.2 LinkageError

`LinkageError` is a direct subclass of `Error`.

It occurs when a class has a problem during linking.

Linking is part of the class-loading process. It involves verification, preparation, and resolution.

Linkage problems can occur when classes or libraries are incompatible or when required dependencies cannot be found.

Some important subclasses of `LinkageError` are:

- `NoClassDefFoundError`
- `ClassFormatError`
- `UnsatisfiedLinkError`
- `VerifyError`
- `IncompatibleClassChangeError`

#### A. NoClassDefFoundError

It occurs when the JVM cannot find a class definition that was available when the program was compiled or previously linked.

**Example scenario:**

1. We compile an application using an external library.
2. The application compiles successfully.
3. Later, the required library or class is removed from the runtime classpath.
4. During execution, the JVM attempts to load that class.
5. The class definition cannot be found.
6. JVM may throw `NoClassDefFoundError`.

**Important:** `NoClassDefFoundError` is different from `ClassNotFoundException`.

| ClassNotFoundException                                                                 | NoClassDefFoundError                                                                                   |
|----------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|
| It is an Exception.                                                                    | It is an Error.                                                                                        |
| It is a checked exception.                                                             | It is an unchecked Error.                                                                              |
| Commonly occurs during explicit class loading using methods such as `Class.forName()`. | Commonly occurs when the JVM cannot find a class definition needed during normal linking or execution. |

#### B. ClassFormatError

It occurs when the JVM encounters an invalid class-file format.

For example, a corrupted or improperly generated `.class` file may cause this Error.

#### C. UnsatisfiedLinkError

It occurs when the JVM cannot find a required native method implementation or native library.

Java can interact with native code using mechanisms such as JNI (Java Native Interface).

If a required native implementation is unavailable, the JVM may throw this Error.

#### D. VerifyError

It occurs when a class file fails JVM bytecode verification.

The JVM verifies bytecode to ensure that it follows required structural and safety rules.

#### E. IncompatibleClassChangeError

It occurs when an incompatible change in a class definition causes a linkage problem.

For example, an application may have been compiled against one version of a class, but an incompatible version is present at runtime.

### 3.3 AssertionError

`AssertionError` is a direct subclass of `Error`.

It occurs when an assertion statement evaluates to `false`.

Assertions are used by developers to check assumptions about program state.

**Syntax:**

```java
assert condition;
```

We can also provide a custom message:

```java
assert condition : "Error message";
```

**Example:**

```java
public class Driver {

    public static void main(String[] args) {

        int age = 15;

        assert age >= 18 : "Age must be 18 or above";

        System.out.println("Program continues");

    }
}
```

To enable assertions, run the program using:

```bash
java -ea Driver
```

**Output when assertions are enabled:**

```text
Exception in thread "main" java.lang.AssertionError: Age must be 18 or above
```

**Important points:**

1. Assertions are disabled by default.
2. Use `-ea` to enable assertions.
3. An assertion that evaluates to false throws `AssertionError`.
4. Assertions are primarily used for checking internal assumptions during development and testing.
5. Do not use assertions for validating normal external input, such as user-provided age or passwords.

### 3.4 ThreadDeath

`ThreadDeath` is a direct subclass of `Error`.

It is associated with the termination of a thread through the deprecated `Thread.stop()` mechanism.

When `Thread.stop()` is invoked, the JVM may throw `ThreadDeath` in the target thread.

**Important:** `Thread.stop()` is deprecated because it can terminate a thread while it is modifying shared data, potentially leaving the application in an inconsistent state.

Modern Java applications should use cooperative thread interruption and proper synchronization instead.

## 4. Can We Handle Errors Using Try-Catch?

Yes.

Java allows us to catch an Error because `Error` extends `Throwable`.

However, catching an Error does not necessarily solve the underlying problem.

**Example:**

```java
public class Driver {

    public static void main(String[] args) {

        try {

            throw new StackOverflowError("Stack memory problem");

        }
        catch (StackOverflowError e) {

            System.out.println("Error caught");

        }

        System.out.println("Program continues");

    }
}
```

**Output:**

```text
Error caught
Program continues
```

**Explanation:**

1. We explicitly create a `StackOverflowError` object.
2. We throw it using the `throw` keyword.
3. The catch block catches the Error.
4. Execution continues after the catch block.

**Important:** This example demonstrates that an Error can be caught. It does not demonstrate recovery from an actual stack overflow. Catching a real `StackOverflowError` may not leave the application in a safe state.

## 5. Difference Between Error and Exception

Both `Error` and `Exception` extend `Throwable`, but they represent different categories of problems.

| Feature           | Error                                      | Exception                                              |
|-------------------|--------------------------------------------|--------------------------------------------------------|
| Parent class      | Throwable                                  | Throwable                                              |
| Nature            | Generally serious JVM or low-level problem | Exceptional condition that application code may handle |
| Compiler checking | Unchecked                                  | Can be checked or unchecked                            |
| Handling          | Generally not recommended                  | Commonly handled                                       |
| Recovery          | Often difficult                            | Often possible                                         |
| Examples          | OutOfMemoryError, StackOverflowError       | IOException, NullPointerException                      |

**Remember:**

- `Error` is unchecked.
- `RuntimeException` and its subclasses are unchecked exceptions.
- Checked exceptions are subclasses of `Exception` that are not subclasses of `RuntimeException`.

## 6. Error vs RuntimeException

This is an important interview topic because both are unchecked.

| Feature              | Error                            | RuntimeException                                         |
|----------------------|----------------------------------|----------------------------------------------------------|
| Parent               | Throwable                        | Exception                                                |
| Nature               | Serious JVM or low-level problem | Usually application-level programming or runtime problem |
| Compiler requirement | No handling required             | No handling required                                     |
| Examples             | StackOverflowError               | NullPointerException                                     |
| Common handling      | Generally not handled            | Can be handled when appropriate                          |

**Example of Error:**

```java
throw new StackOverflowError("Stack exhausted");
```

**Example of RuntimeException:**

```java
int result = 10 / 0;
```

The second example produces an `ArithmeticException`, which is a subclass of `RuntimeException`.

## 7. Why Should We Generally Not Catch Errors?

Errors generally indicate serious problems that cannot be reliably corrected by ordinary application-level exception handling.

Consider the following examples:

1. **OutOfMemoryError:** The JVM may not have sufficient memory to allocate objects or perform further operations.
2. **StackOverflowError:** The thread's stack has been exhausted, and further method execution may not be safe.
3. **LinkageError:** The application may have incompatible or missing runtime dependencies.

Catching these Errors and simply printing a message does not repair the underlying problem.

**Best practice:** Identify and fix the root cause rather than using catch blocks as a general solution for Errors.

## 8. Important Interview Questions on Error

**Q1. Is Error a checked or unchecked type?**

Answer: Error is unchecked. The compiler does not force us to catch or declare it.

**Q2. Can we catch an Error using try-catch?**

Answer: Yes. Error extends Throwable, so it can be caught. However, recovery is not guaranteed.

**Q3. Is StackOverflowError a direct subclass of Error?**

Answer: No. It extends VirtualMachineError, which extends Error.

**Q4. Is OutOfMemoryError a checked exception?**

Answer: No. It is an unchecked Error.

**Q5. What is the difference between StackOverflowError and OutOfMemoryError?**

Answer:

- StackOverflowError occurs when a thread's stack space is exhausted.
- OutOfMemoryError occurs when the JVM cannot allocate sufficient memory for an object or operation.

**Q6. Is AssertionError an Exception?**

Answer: No. AssertionError is a direct subclass of Error.

**Q7. What is the difference between ClassNotFoundException and NoClassDefFoundError?**

Answer:

- ClassNotFoundException is a checked Exception, commonly associated with explicit class loading.
- NoClassDefFoundError is an Error associated with a missing class definition during linking or execution.

**Q8. Is VirtualMachineError a direct subclass of Throwable?**

Answer: No. VirtualMachineError extends Error, and Error extends Throwable.

**Q9. Can we create our own Error class?**

Answer: Technically, yes. We can extend Error. However, application-specific problems should generally be represented using custom checked exceptions or unchecked exceptions.

**Q10. Are all Errors caused by insufficient memory?**

Answer: No. Errors can occur due to memory exhaustion, stack exhaustion, class-linking problems, failed assertions, and other serious conditions.

## 9. Quick Revision Table

| Class                        | Parent Class        | Category |
|------------------------------|---------------------|----------|
| Error                        | Throwable           | Error    |
| VirtualMachineError          | Error               | Error    |
| OutOfMemoryError             | VirtualMachineError | Error    |
| StackOverflowError           | VirtualMachineError | Error    |
| InternalError                | VirtualMachineError | Error    |
| UnknownError                 | VirtualMachineError | Error    |
| LinkageError                 | Error               | Error    |
| NoClassDefFoundError         | LinkageError        | Error    |
| ClassFormatError             | LinkageError        | Error    |
| UnsatisfiedLinkError         | LinkageError        | Error    |
| VerifyError                  | LinkageError        | Error    |
| IncompatibleClassChangeError | LinkageError        | Error    |
| AssertionError               | Error               | Error    |
| ThreadDeath                  | Error               | Error    |

## 10. Final Summary

1. `Error` directly extends `Throwable`.
2. Errors are unchecked.
3. Errors generally indicate serious JVM or low-level problems.
4. `VirtualMachineError` is a subclass of Error.
5. `OutOfMemoryError` and `StackOverflowError` extend VirtualMachineError.
6. `LinkageError` represents class-linking problems.
7. `AssertionError` occurs when an enabled assertion fails.
8. `ThreadDeath` is associated with the deprecated `Thread.stop()` mechanism.
9. Errors can technically be caught using try-catch.
10. Catching an Error does not guarantee that the application can recover.
11. Errors should not be used for ordinary application-level exceptional conditions.

**Most important hierarchy to remember:**

```text
Object
   |
Throwable
   |
   |-------------------------|
   |                         |
 Error                    Exception
   |                         |
   |                    RuntimeException
   |                         |
   |                    NullPointerException
   |
   |-------------------------------|
   |               |               |
VirtualMachineError LinkageError AssertionError
   |               |
   |               |
   |          NoClassDefFoundError
   |
   |----------------------|
   |                      |
OutOfMemoryError   StackOverflowError
```