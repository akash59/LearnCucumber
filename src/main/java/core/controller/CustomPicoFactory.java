package core.controller;


import io.cucumber.core.backend.ObjectFactory;
import io.cucumber.picocontainer.PicoFactory;

public class CustomPicoFactory implements ObjectFactory {

    private PicoFactory delegate = new PicoFactory();

    public CustomPicoFactory() {
        switch (DriverType.getType()) {
            case FIREFOX:
                addClass(FirefoxController.class);
                break;
            case CHROME:
                addClass(ChromeController.class);
                break;
            default: // if no device is specified, use firefox
                throw new RuntimeException("Unsupported browser type");
        }
    }

    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void stop() {
        delegate.stop();
    }

    @Override
    public boolean addClass(Class<?> aClass) {
        return delegate.addClass(aClass);
    }

    @Override
    public <T> T getInstance(Class<T> aClass) {
        return delegate.getInstance(aClass);
    }
}
