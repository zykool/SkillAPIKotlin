package com.sucy.skill.dynamic.trigger

import com.sucy.skill.facade.api.entity.Actor
import com.sucy.skill.facade.api.event.actor.ToggleCrouchEvent

/**
 * SkillAPI © 2018
 */
class CrouchTrigger : Trigger<ToggleCrouchEvent>() {

    /** {@inheritDoc}  */
    override val key: String
        get() = "CROUCH"

    /** {@inheritDoc}  */
    override val event: Class<ToggleCrouchEvent>
        get() = ToggleCrouchEvent::class.java

    /** {@inheritDoc}  */
    override fun shouldTrigger(event: ToggleCrouchEvent, level: Int): Boolean {
        val type = metadata.getString("type", "start crouching")
        return type.equals("both", ignoreCase = true) || event.isCrouching != type.equals("stop crouching", ignoreCase = true)
    }

    /** {@inheritDoc}  */
    override fun getCaster(event: ToggleCrouchEvent): Actor {
        return event.actor
    }

    /** {@inheritDoc}  */
    override fun getTarget(event: ToggleCrouchEvent): Actor {
        return event.actor
    }
}
