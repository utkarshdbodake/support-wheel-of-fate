# Support wheel of fate

A web-server (with HTTP APIs) that manages assigning employees to a support schedule.
Check out android client app here: https://play.google.com/store/apps/details?id=com.zenpanda.supportwheel

-----
# Entities
### Engineer Entity
```
    {
        "id": "1",
        "name": "Sam"
    }
    - Represents single engineer along with its info.

    - Why `id` field is `String` data type instead of `int/long` data type?
        --> Because in JS (as most of our web clients would be in JS) the Number cannot go beyond `9007199254740991`. So we don't want to limit the number of records in our table by mere **JS language's data type limitation**! That's why all id's are choosen to be of `String` data type.
```
### SingleDaySchedule Entity
```
    {
        "date": "Monday 21-05-2018",
        "engineers": [
            <Engineer entity>
        ]
    }
    - Represents support schedule of the single day.
    - The number of engineers in array are depended upon various factors such as shift length & availability of engineers.
```
### Schedule Entity
```
    {
        "schedule": [
            <SingleDaySchedule entity>
        ]
    }
    - Represents holistic schedule of all the engineers on respective working dates.
```
-----

# APIs
###
- Structure: ```BASE_URI/schedule```
- Deployed API: https://u7p5iyghil.execute-api.us-east-1.amazonaws.com/staging/schedule
- HTTP method: POST
- Input payload (Optional):
    ```
        {
            "startDate": "25-8-2018"
        }

        Note: For any invalid/missing inputs, we default to startDate to the current date.
    ```
- Example using cURL request:
    ```

    curl -X POST \
      https://u7p5iyghil.execute-api.us-east-1.amazonaws.com/staging/schedule \
      -H 'Cache-Control: no-cache' \
      -H 'Content-Type: application/json' \
      -H 'Postman-Token: aa20f6b2-3d26-4fcd-9669-e851a76b65c3' \
      -H 'x-api-key: IK21Pbj46Z0EpuDEBT3Z9pC4CrmD0pkaaoXHbq7c' \
      -d '{
    	    "startDate": "25-5-2018"
        }'
    ```
    ```
    Success response
    Status code: 200 OK
    Response payload:
    {
        "schedule": [
            {
                "date": "Mon 01-01-2018",
                "engineers": [
                    {
                        "id": "2",
                        "name": "Sam"
                    },
                    {
                        "id": "5",
                        "name": "John"
                    }
                ]
            },
            ...
        ]
    }
    ```

    ```
    Failure responses

    Status code: 422
    Response payload:
    {
        "message": "Limit exceeded"
    }
    ```

-----
# Approach
 ```
    *** Generic Flow ***
    1. First we calculate the working dates from the given start date (if not given then current date is considered). Saturday and Sunday are omitted from working days.
    2. Construct single day schedule by finding out the available engineers which abide by the given constraints/rules.
    3. Repeat step 2, till we will out single day schedules for all the working days.

    *** Finding available engineer ***
    1. We maintain all the engineers in memory in a List.
    2. One tracker pointer is used to track the position of the picked available engineer last time.
    3. We traverse through the List in search of an available engineer which abides by the rule.
    4. If none of available engineers are found in 1st iteration through list, we again traverse the list from start to end 2nd time, if even then no engineers are found in 2nd iteration, then we conclude that there are no available engineers left and hence forth there would be no engineers left for the post working days in schedule.
    5. Note: All engineers are scheduled in Round robin fashion.
 ```
-----
# Known Limitations
 ```
    1. No database is used for now to store all the engineers.
    2. All the constants (like number of support days, number of shifts in day, etc) are hard coded in code as of now, though this may be moved to environment variables in future.
 ```
-----
# Test cases

- Unit Test cases have been added for checking various rules for support scheduler.
