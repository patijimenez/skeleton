
quartz {
    autoStartup = false
    jdbcStore = false
    waitForJobsToCompleteOnShutdown = true
}

environments {
	dgticDev {
		quartz {
			autoStartup = false
		}
	}
    test {
        quartz {
            autoStartup = false
        }
    }
	
}
