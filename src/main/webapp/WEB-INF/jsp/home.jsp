<div class="container">


    <div id="header" class="span-24 last">

        <h1 id="aestas main"><img src="<c:url value="/resources/images/logo.png"/>" alt="Aestas header image" id="header-image"/></h1>
    </div>
    <hr/>
    <div id="subheader" class="span-24 last">
        <h3 class="alt" style="color:white;">Aestas IT - Cloud Foundry test drive</h3>
    </div>
    <hr/>
    <div class="span-17 colborder" id="content">
        <div>

            <form action="redisPut/" method="post">
                <fieldset>
                <p>
                    <label for="redis-value" style="color:white;">Redis Value</label>
                    <textarea id="redis-value" name="content" rows="1"></textarea>
                </p>
                <p>
                    <label for="redis-key1" style="color:white;">Redis Key</label>
                    <input id="redis-key1" name="name" type="text"/>
                </p>
                <p>
                    <input type="submit" value="send to redis!"/>
                </p>

                </fieldset>
            </form>

        </div>
        <div>
            <fieldset>
            <p>
                <label for="redis-key2" style="color:white;">Redis Key</label>
                <input id="redis-key2" name="name" type="text"/>
            </p>
            <p>
            <input type="submit" value="read from redis!" id="redis-get"/>
            </p>
            </fieldset>
        </div>

        <div class="box" id="response">


        </div>

    </div>


    <div class="span-6 last" id="sidebar">
        <div class="box">
        <a href="http://www.aestasit.com">Aestas</a></p>
        <a href="http://blog.aestasit.com">Aestas Blog</a>
        </div>
    </div>


</div>
<script>
    $("#redis-get").click(function () {
        $.getJSON('<c:url value="/redisGet/"/>', { name : $("#redis-key2").val() }, function(resp) {
            //alert (resp.content)
            $("#response").html('key: ' + resp.name + '<p style="text-align: justify;">content: ' + resp.content);
        });

    });
</script>
