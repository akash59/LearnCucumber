package logging;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public class MyNiceAppendable implements Appendable {

    private static final CharSequence NL = "\n";
    private final Appendable out;

    public MyNiceAppendable(Appendable out) {
        this.out = out;
    }

    public MyNiceAppendable println() {
        return append(NL);
    }

    public MyNiceAppendable append(CharSequence csq) {
        try {
            out.append(csq);
            tryFlush();
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MyNiceAppendable append(CharSequence csq, int start, int end) {
        try {
            out.append(csq, start, end);
            tryFlush();
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MyNiceAppendable append(char c) {
        try {
            out.append(c);
            tryFlush();
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void tryFlush() {
        if (!(out instanceof Flushable)) {
            return;
        }

        try {
            ((Flushable) out).flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MyNiceAppendable println(CharSequence csq) {
        try {
            out.append(csq).append(NL);
            tryFlush();
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            tryFlush();
            if (out instanceof Closeable) {
                ((Closeable) out).close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
