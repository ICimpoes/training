case class Email(subject: String, text: String, sender: String, recipient: String)

type EmailFilter = Email => Boolean
type SizeChecker = Int => Boolean
type IntPairPred = (Int, Int) => Boolean
def newMailsForUser(mails: Seq[Email], f: EmailFilter) = mails.filter(f)

def complement[A](predicate: A => Boolean) = (a: A) => !predicate(a)
def any[A](predicates: (A => Boolean)*): A => Boolean = a => predicates.exists(_(a))
def none[A](predicates: (A => Boolean)*) = complement(any(predicates: _*))
def every[A](predicates: (A => Boolean)*): A => Boolean = a => predicates.forall(_(a))

val sentByOneOf: Set[String] => EmailFilter =
  senders => email => senders.contains(email.sender)
val notSentByAnyOf: Set[String] => EmailFilter = sentByOneOf andThen complement
def sizeConstraint(pred: IntPairPred)(n: Int)(email: Email) = pred(email.text.size, n)
val gt: IntPairPred = _ > _
val ge: IntPairPred = _ >= _
val lt: IntPairPred = _ < _
val le: IntPairPred = _ <= _
val eq: IntPairPred = _ == _
val minimumSize: (Int, Email) => Boolean = sizeConstraint(ge) _
val maximumSize: (Int, Email) => Boolean = sizeConstraint(le) _
val constr20: (IntPairPred, Email) => Boolean = sizeConstraint(_: IntPairPred)(20) _
val constr30: (IntPairPred, Email) => Boolean = sizeConstraint(_: IntPairPred)(30) _
val minimum20: (Email) => Boolean = constr20(ge, _: Email)
val maximum30: (Email) => Boolean = constr30(le, _: Email)
val e1 = Email("sub1", "text_blah_ad__gt_20_lt30", "1@e.com", "r@e.com")
val e2 = Email("", "text_blah_blah", "2@e.com", "r@e.com")
val e3 = Email("sub3", "txt_blah_blah_blah", "3@e.com", "r@e.com")
val mailList = Seq(e1, e2, e3)
newMailsForUser(mailList, sentByOneOf(Set("1@e.com", "2@e.com")))
val f1 = every(notSentByAnyOf(Set("1@e.com", "2@e.com")), minimumSize(10, _: Email), maximum30(_: Email))
val f2 = every(notSentByAnyOf(Set("2@e.com", "3@e.com")), constr20(gt, _: Email), constr30(lt, _: Email))
newMailsForUser(mailList, f1)
newMailsForUser(mailList, f2)
//---------------------------------------
val addMissingSubject = (email: Email) =>
  if (email.subject.isEmpty) email.copy(subject = "No subject")
  else email
val checkSpelling = (email: Email) =>
  email.copy(text = email.text.replaceAll("txt", "text"))
val removeInappropriateLanguage = (email: Email) =>
  email.copy(text = email.text.replaceAll("blah", "**CENSORED**"))
val addAdvertisementToFooter = (email: Email) =>
  email.copy(text = email.text + "\nThis mail sent via Super Awesome Free Mail")

val pipeline = Function.chain{Seq(
  addMissingSubject,
  checkSpelling,
  removeInappropriateLanguage,
  addAdvertisementToFooter
)}
mailList.map(pipeline)
//--------------------------------------------