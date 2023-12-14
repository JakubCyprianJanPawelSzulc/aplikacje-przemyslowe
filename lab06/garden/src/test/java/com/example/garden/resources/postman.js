// localhost:8080/plants
//get

pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response body is a JSON array", function () {
    pm.response.to.be.json;
    pm.response.to.have.jsonBody("array");
});


// localhost:8080/plants/{id}
// get

pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
}
);

pm.test("Response body is a JSON object", function () {
    pm.response.to.be.json;
    pm.response.to.have.jsonBody("object");
}
);

// localhost:8080/plants
// post
// {
//     "name": "boxwood",
//     "type": "tree",
//     "color": "green"
// }

pm.test("Status code is 201", function () {
    pm.response.to.have.status(201);
}
);

// localhost:8080/plants/{id}
// {
//     "name": "ive",
//     "type": "climber",
//     "color": "green"
// }

pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
}
);

//localhost:8080/plants/{id}
// delete
pm.test("Status code is 204", function () {
    pm.response.to.have.status(204);
});
