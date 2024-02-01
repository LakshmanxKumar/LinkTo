# LinkTo
This is an API for generating short links.

It takes a get request to receive the longlink from the database<br>
end-point for get request `/get/{id}`

To use the api for redirecting to different link make a get request to `/goto/{id}`

It takes a post request to save the long URL<br>
end-point for post request `/savelink`


Sample for the post-request  

```
{   
    "longLink":"https://www.sampelURl.com.me",
    "randomStringAssignment":"true"
} 
```
```
{   
    "longLink":"https://www.sampelURl.com.me",
    "randomIdAssignment":"true"
} 
```
```
{   
    "longLink":"https://www.sampelURl.com.me",
    "customString":"myslug"
} 
```

At a time it is recommended to provide only one of these 3 <br>`customString` `randomIdAssignment` `randomStringAssignment`.
<br> Incase you want to use others, make sure only one of them is set true.
<br> Note : Writing anything in `customString` makes this field true.

Make sure to set ` Content-Type: application/json `

### API IS LIVE
[Link](https://linkto.onrender.com) : "https://linkto.onrender.com"


