package main.java.com.example.kmeter

class HybridClientConfig internal constructor(
    private var timeoutForShortRoute: Long,
    private var timeoutForMediumRoute: Long,
    private var timeoutForLongRoute: Long,
    private var timeoutForOldEmbeddedDataVersion:Long,
) {

    private constructor(builder: Builder) : this(
        timeoutForShortRoute = builder.timeoutForShortRoute,
        timeoutForMediumRoute = builder.timeoutForMediumRoute,
        timeoutForLongRoute = builder.timeoutForLongRoute,
        timeoutForOldEmbeddedDataVersion = builder.timeoutForOldEmbeddedDataVersion
    )

    /**
     * Builder class used by the sdk user in order to create a [HybridClientConfig] instance.
     */
    class Builder {
        /**
         * The timeout threshold is for short route, whose distance range is 0 ~ 50km.
         * It's default value is 2000 millisecond.
         */
        internal var timeoutForShortRoute: Long = 2000L

        /**
         * The timeout threshold is for medium route, whose distance range is 50 ~ 1000km.
         * It's default value is 3000 millisecond.
         */
        internal var timeoutForMediumRoute: Long = 3000L

        /**
         * The timeout threshold is for long route, whose distance range is 1000km ~ unlimited.
         * It's default value is 5000 millisecond.
         */
        internal var timeoutForLongRoute: Long = 5000L

        /**
         * The timeout threshold is for hybrid routing
         * When onboard returns firstly,but onboard uses old data, wait for the result returned by cloud in the timeout period.
         * It's default value is 15000 millisecond.
         */
        internal var timeoutForOldEmbeddedDataVersion: Long = 15000L

        /**
         * @param timeout `Long` specifying timeout threshold by millisecond unit.
         * Note: It's invalid for specifying a negative value and it will keep original 2000 default value.
         */
        fun setTimeoutForShortRoute(timeout: Long): Builder {
            if (timeout > 0) {
                this.timeoutForShortRoute = timeout
            }
            return this
        }

        /**
         * @param timeout `Long` specifying timeout threshold by millisecond unit.
         * Note: It's invalid for specifying a negative value and it will keep original 3000 default value.
         */
        fun setTimeoutForMediumRoute(timeout: Long): Builder {
            if (timeout > 0) {
                this.timeoutForMediumRoute = timeout
            }
            return this
        }

        /**
         * @param timeout `Long` specifying timeout threshold by millisecond unit.
         * Note: It's invalid for specifying a negative value and it will keep original 5000 default value.
         */
        fun setTimeoutForLongRoute(timeout: Long): Builder {
            if (timeout > 0) {
                this.timeoutForLongRoute = timeout
            }
            return this
        }

        /**
         * @param timeout `Long` specifying timeout threshold by millisecond unit.
         * Note: It's invalid for specifying a negative value and it will keep original 15000 default value.
         */
        fun setTimeoutForOldEmbeddedDataVersion(timeout: Long): Builder {
            if (timeout > 0) {
                this.timeoutForOldEmbeddedDataVersion = timeout
            }
            return this
        }

        fun build() = HybridClientConfig(this)
    }


    fun timeoutForShortRoute(): Long = timeoutForShortRoute

    fun timeoutForMediumRoute(): Long = timeoutForMediumRoute

    fun timeoutForLongRoute(): Long = timeoutForLongRoute

    fun timeoutForOldEmbeddedDataVersion(): Long = timeoutForOldEmbeddedDataVersion
}