Scenario: Detect the safety status
Given the smoke level is <level>
When the smoke level is assessed
Then the safety status will be <status>

Examples:
|level|status|
|0|SAFE|
|5|SAFE|
|6|WARNING|
|13|WARNING|
|14|EMERGENCY|
|15|EMERGENCY|
