package com.group11.ctfish.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import com.group11.ctfish.model.Hook;

public class HookController {
    private Hook hook;

    public HookController(Hook hook) {
        this.hook = hook;
    }

    public void update() {
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(hook.getHook().x, Gdx.input.getY(), 0);
            hook.getHook().y = touchPos.y;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) hook.getHook().y -= 20 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) hook.getHook().y += 20 * Gdx.graphics.getDeltaTime();
    }
}
