let onlyOneEmoji = true;
        for(let i = 1; i <= 18; i++){
            $('#emojiBox').append($(`<img class='emoji' src='emoji${i}.png'>`));
        }
        let sendByEnter = (e) => {
            if (e.key == 'Enter') {
                send()
            }
        }
        let send = () => {
            if($('#inputTxt').html() == '<br>') {return}
            if (($('#inputTxt').html().trim() != '' || $('#inputEmoji').html().trim() != '')&& $('#user').prop('checked') == true) {
                let time = moment().format('hh:mm');
                let txt = $('<p>').addClass('pTxtStyle').append($('#inputTxt').html());
                let emo = $('#inputEmoji').html();
                let chat = $('<div>').addClass('chatTxt');
                if(emo != ''){
                    chat.prepend(emo, '<br>').append(txt);
                } else{
                    chat.prepend(emo).append(txt);
                }
                let chatLine = $('<div>').addClass('chatLineMine').append(chat);
                let chatTime = $('<div>').addClass('chatTime').append(time);
                chatLine.append(chatTime);
                $('#chatBox').append(chatLine);
                $('#inputTxt, #inputEmoji').text('').focus();
                scrollBottom();
                $('#emojiBox').addClass('hide');
                $('#emojiButton').removeClass('fa-bounce');
                onlyOneEmoji = true;
            } else if (($('#inputTxt').html().trim() != '' || $('#inputEmoji').html().trim() != '')&& $('#user').prop('checked') == false) {
                let time = moment().format('hh:mm');
                let txt = $('<p>').addClass('pTxtStyle').append($('#inputTxt').html());
                let emo = $('#inputEmoji').html();
                let chat = $('<div>').addClass('chatTxt');
                if(emo != ''){
                    chat.prepend(emo, '<br>').append(txt);
                } else{
                    chat.prepend(emo).append(txt);
                }
                let chatLine = $('<div>').addClass('chatLineOpponent').append(chat);
                let chatTime = $('<div>').addClass('chatTime').append(time);
                chatLine.append(chatTime);
                $('#chatBox').append(chatLine);
                $('#inputTxt, #inputEmoji').text('').focus();
                scrollBottom();
                $('#emojiBox').addClass('hide');
                $('#emojiButton').removeClass('fa-bounce');
                onlyOneEmoji = true;
            } 
        }
        let div = document.querySelector('#inputTxt');
        div.onkeyup = function (e) {
            let a = document.activeElement;
            if (a.lastChild && a.lastChild.nodeName != 'BR') {
                a.appendChild(document.createElement('br'));
                scrollInputBox();
            }
        };
        div.onkeypress = function (e) {
            if (e.keyCode == 13 && e.shiftKey == true) {
                let selection = window.getSelection(),
                    range = selection.getRangeAt(0),
                    br = document.createElement('br');
                range.deleteContents();
                range.insertNode(br);
                range.setStartAfter(br);
                range.setEndAfter(br);
                range.collapse(false);
                selection.removeAllRanges();
                selection.addRange(range);
                scrollInputTxt();
                return false;
            } else if (e.keyCode == 13 && e.shiftKey == false) {
                let selection = window.getSelection(),
                    range = selection.getRangeAt(0),
                    br = document.createElement('br');
                range.deleteContents();
                selection.removeAllRanges();
                selection.addRange(range);
                sendByEnter(e);
                scrollInputTxt();
                return false;
            }
        };
        $('#sendButton').on('click', send)
        $('#emojiButton').on('click', function () {
            $('#emojiBox').toggleClass('hide');
            $('#emojiButton').toggleClass('fa-bounce');
        })
        $('img').on('click', function () {
            if (onlyOneEmoji) {
                onlyOneEmoji = false;
                $('#inputEmoji').prepend($(this).clone());
                $('#inputTxt').focus();
                scrollInputTop();
            } else {
                $('#inputEmoji').empty();
                $('#inputEmoji').prepend($(this).clone());
                $('#inputTxt').focus();
                scrollInputTop();
            }
        })

        function scrollBottom() {
            let scroll = document.querySelector('#chatBox');
            scroll.scrollTop = scroll.scrollHeight;
        }
        function scrollInputBox() {
            let scroll = document.querySelector('#inputBox');
            scroll.scrollTop = scroll.scrollHeight;
        }
        function scrollInputTxt() {
            let scroll = document.querySelector('#inputTxt');
            scroll.scrollTop = scroll.scrollHeight;
        }
        function scrollInputTop() {
            let scroll = document.querySelector('#inputBox');
            scroll.scrollTop = 0;
        }