/**
 * @author github.com/jamesdeperio
 * @version codepocket template builder v1.0
 */
package io.github.jamesdeperio.architecture.global.module.appconfig

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.github.jamesdeperio.architecture.global.scope.ApplicationScope
import io.github.jamesdeperio.architecture.integration.network.NetworkManager
import jdp.pocketlib.util.Bus
import jdp.pocketlib.util.EventPublisher

@Module
abstract class ApplicationBindingModule {
    @Binds
    internal abstract fun bindContext(application: Application): Context
    //Binds simply means, get a return type from a class(Application) w/c it extend or implements (Context); then use the return type (Context) as a parameter on Provider object

    @Module
    companion object Provider {
        /*
            Provide global module here. (dao,manager, etc..)
            All class that are provided here, can be use in any Sub-Modules.
            Also, class can be injected to (Activity,Fragment) Controller and Services/BroadcastReceiver
         */
        @ApplicationScope
        @Provides
        @JvmStatic
        fun provideEventBus():EventPublisher
                = EventPublisher(Bus.PublishSubject) // manager for event bus (usually used in passing of data from not coupled classes like Activity-Fragment-Service-BroadcastReceiver)

        @ApplicationScope
        @Provides
        @JvmStatic
        fun provideNetworkManager(context: Context): NetworkManager
                = NetworkManager(context = context) // manager for network request
        // context is available to use as a parameter since we bind it above.
    }
}
